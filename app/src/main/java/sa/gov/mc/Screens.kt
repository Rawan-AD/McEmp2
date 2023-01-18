package sa.gov.mc

sealed class Screens(val route: String) {

    // TODO 1: Navigation setup
    object SplashScreen: Screens(route = "login.splash_screen")
    object OnboardScreen: Screens(route = "onboard_screen")

    object HomeScreen: Screens(route = "homeScreen")
    object LoginScreen:Screens(route= "login")
    object OptScreen:Screens(route= "opt_screen")


    object ContactsScreen:Screens(route="contacts.contacts_screen")
    object JobsScreen:Screens(route="Jobs")
    object JobInfoScreen:Screens(route="JobInfo")
    object ProfileUi:Screens(route="profile")
    object ChatUIScreen:Screens(route="chat.chat_ui")
    object NewsUI:Screens(route="NewsUI")
    object News:Screens(route="News")
    object Vocation:Screens(route="vocation")
    object Car:Screens(route="car")
    object EmpJob:Screens(route="emp_job")
    object EmpCard:Screens(route="emp_card")






}
