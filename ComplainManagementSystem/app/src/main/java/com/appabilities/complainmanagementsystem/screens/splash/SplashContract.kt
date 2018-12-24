package com.appabilities.complainmanagementsystem.screens.splash

interface SplashContract {

    /*
   View - this defines the methods that the pure views like Activity or Fragments etc will implement.
    */
    interface View {
        fun setupViews()
    }

    /*
    Actions - this defines the methods the pure Presenter class will implement. Also known as user actions,
    this is where the app logic is defined.
     */
    interface Actions {
        fun initScreen()

    }

    /*
    this defines the methods that pure model or persistence class like database or server data will implement.
     */
    interface Repository

}