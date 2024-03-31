package com.miu.mdp.sporty.Auth.Model
import android.content.Context
import android.util.Log
import com.google.gson.Gson

data class User(
    val email: String,
    val username: String,
    val password: String,
    val picture: String // Assuming picture is stored as a String (file path or URL)
)

object UserPreferences {
    private const val PREFS_NAME = "UserPrefs"
    private const val KEY_USERS = "users"
    private const val AUTH_USER ="authUser"

    private val gson = Gson()

    fun saveUsers(context: Context, users: List<User>) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val usersJson = gson.toJson(users)
        prefs.edit().putString(KEY_USERS, usersJson).apply()
    }

    fun authUser(context: Context,username: String, password: String):Boolean{
        val users = getUsers(context)
        Log.d("info","list of users ")
        Log.v("info",users.toString())
        val user =  users.firstOrNull { (it.email == username ||  it.username == username) && it.password ==password }
        if(user == null)return false
        auth(context, user)
        return true

    }
    fun auth(context: Context, user: User) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val userJson = gson.toJson(user)
        prefs.edit().putString(AUTH_USER, userJson).apply()
    }

    fun un_auth(context: Context) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putString(AUTH_USER, null).apply()
    }

    fun getAuth(context: Context): User? {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val userJson = prefs.getString(AUTH_USER, null)
        return if (userJson != null) {
            gson.fromJson(userJson, User::class.java)
        } else {
            null
        }
    }

    fun getUsers(context: Context): List<User> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val usersJson = prefs.getString(KEY_USERS, null)
        return if (usersJson != null) {
            gson.fromJson(usersJson, Array<User>::class.java).toList()
        } else {
            emptyList()
        }
    }

    fun addUser(context: Context, user: User) {
        val users = getUsers(context).toMutableList()
        users.add(user)
        saveUsers(context, users)
        auth(context, user)
    }

    fun removeUser(context: Context, user: User) {
        val users = getUsers(context).toMutableList()
        users.remove(user)
        saveUsers(context, users)
    }
    fun userExists(context: Context, value: String): Boolean {
        val users = getUsers(context)
        return users.any { it.email == value ||  it.username == value }

}}
