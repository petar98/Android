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
c
