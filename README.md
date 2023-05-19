# MVC-Kotlin-Implementation
MVC Architecture Pattern with Kotlin

## The Model-View-Controller (MVC) architecture pattern is a software design pattern that separates an application into three parts:
<ol>
<li>The Model represents the data of the application.</li>
<li>The View is responsible for displaying the data to the user.</li>
<li>The Controller handles user input and updates the Model accordingly.</li>
</ol>



<pre>The MVC pattern is a popular choice for Android development because it helps to keep the code organized and maintainable. 
It also makes it easier to test the application, since the Model, View, and Controller can be tested independently.</pre>

## Example
<ol>
<li> data Package.
  <pre>Which Contains the <b>data class</b>,which is called here <b>User</b></pre>
  
### User.kt
  
  ```kt
  data class User(val userName: String?, val password: String?)
  ```
  </li>
<li>database Package.
  <pre>Which Contains the <b>Database class</b>,which is called here <b>Database</b> which contains an object ,to apply the concept <b>singleton design pattern</b>, this object contains a function called getCurrentUser() which in turn returns a User Object.
  </pre>
  
  ### Database.kt
  
  ```kt
class Database {
    companion object Database {
        fun getCurrentUser(): User {
            return User("Abdelrahman", "12345")
        }
    }
}
  ```
  
  </li>
<li>ui package. 
  <pre>which contains the <b>Controller</b>,which contains the Container Class that listen any event from the view and then go to the model(database) to get the data back to the view </pre>
  
  ### Controller.kt
  
  ```kt
  class Controller {
    fun login(userName: String?, password: String?): Int {
        return if (userName == getCurrentUser().userName &&
            password == getCurrentUser().password
        ) 1
        else 0
    }
}
  ```
 
  </li>
 <li>Finally the View
   
   ### MainActivity.kt
   ```kt
   private lateinit var binding: ActivityMainBinding
private val controller: Controller = Controller()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }

    private fun initUi() {
        val userName = binding.usernameEdittext
        val userPassword = binding.passwordEdittext

        binding.btnLogin.setOnClickListener {
            if (controller.login(userName.text.toString(), userPassword.text.toString()) == 1) {
                Toast.makeText(this, "Login Succeeded", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
```   
   
   
</ol>
