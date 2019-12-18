# Android
Training projects from the android java and kotlin courses:

  Java   -> https://developer.android.com/courses/fundamentals-training/toc-v2

  Kotlin -> https://developer.android.com/courses/kotlin-android-fundamentals/to

  Steps to use data binding to replace calls to findViewById():
  
    1.  Enable data binding in the android section of the build.gradle file:
    	  dataBinding { enabled = true }
    2.  Use <layout> as the root view in your XML layout.
    3.  Define a binding variable:
    	  private lateinit var binding: ActivityMainBinding
    4.  Create a binding object in MainActivity, replacing setContentView:
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    5. 	Replace calls to findViewById() with references to the view in the binding object. For example:
        findViewById<Button>(R.id.done_button) ⇒ binding.doneButton
    (In the example, the name of the view is generated camel case from the view's id in the XML.)

Steps for binding views to data:

    Create a data class for your data.
    Add a <data> block inside the <layout> tag.
    Define a <variable> with a name, and a type that is the data class.

<data>
   <variable
       name="myName"
       type="com.example.android.aboutme.MyName" />
</data>

    In MainActivity, create a variable with an instance of the data class. For example:
    private val myName: MyName = MyName("Aleks Haecky")

    In the binding object, set the variable to the variable you just created:
    binding.myName = myName

    In the XML, set the content of the view to the variable that you defined in the <data> block. Use dot notation to access the data inside the data class.
    android:text="@={myName.name}"


Navigation and Implicit intents: 
    This application contains examples of navigation graph fragments and implicit intents for sharing:
        https://github.com/google-developer-training/android-kotlin-fundamentals-apps/tree/master/AndroidTrivia
