@file:OptIn(ExperimentalAnimationApi::class)

package sa.gov.mc

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import sa.gov.mc.screens.SplashScreen
import sa.gov.mc.screens.chat.ChatUI
import sa.gov.mc.screens.contacts.ContactsScreen
import sa.gov.mc.screens.home.*
import sa.gov.mc.screens.jobs.EmpJob

import sa.gov.mc.screens.jobs.JobInfo
import sa.gov.mc.screens.jobs.JobsUI
import sa.gov.mc.screens.login.LoginScreen
import sa.gov.mc.screens.login.OptScreen
import sa.gov.mc.screens.onboarding.OnboardingUI


import sa.gov.mc.screens.news.NewDetails
import sa.gov.mc.screens.news.NewsUI
import sa.gov.mc.screens.profile.EmpCard
import sa.gov.mc.screens.profile.ProfileUi


@OptIn(ExperimentalPagerApi::class, ExperimentalAnimationApi::class)
@Composable
fun SetupNavGraph(
    navController: NavHostController
) {

    // TODO 4: Navigation setup
    NavHost(
        navController = navController, startDestination = Screens.SplashScreen.route
    ) {

        // TODO 6: Navigation setup (from)
        composable(
            route = Screens.SplashScreen.route
        ) {
           SplashScreen(navController = navController)
        }

        // TODO 7: Navigation setup (to)
        composable(
            route = Screens.OnboardScreen.route
        ) {
            OnboardingUI(navController = navController)
        }

        // TODO 7: Navigation setup (to)
        composable(
            route = Screens.LoginScreen.route
        ) {
            LoginScreen(navController = navController)
        }
        // TODO 7: Navigation setup (to)
        composable(
            route = Screens.OptScreen.route
        ) {
            OptScreen(navController = navController)
        }
        // TODO 7: Navigation setup (to)
        composable(
            route = Screens.HomeScreen.route
        ) {
        HomeScreenParentHome(navController = navController)
        }
        composable(
            route = Screens.ProfileUi.route
        ) {
         ProfileUi(navController )
        }
        composable(
            route = Screens.JobsScreen.route
        ) {
            JobsUI(navController = navController)

        }
        composable(
            route = Screens.JobInfoScreen.route
        ) {
            JobInfo(navController=navController)

        }
        composable(
            route = Screens.ContactsScreen.route
        ) {
            ContactsScreen(navController)

        }
        composable(
            route = Screens.ChatUIScreen.route
        ) {
            ChatUI(navController)

        }
        composable(
            route = Screens.News.route
        ) {
           NewDetails(navController)

        }
//        composable(
//            route = "_homeScreen"
//        ) {
//            HomeScreen(navController=navController)
//
//        }
        composable(
            route = "vocation"
        ) {
            VocationRequest(navController=navController)

        }
        composable(
            route = "car"
        ) {
            CarPermit(navController)

        }
        composable(
            route = "emp_job"
        ) {
          EmpJob(navController = navController)

        }
        composable(
            route = "NewsUI"
        ) {
           NewsUI(navController)

        }

        composable(
            route = Screens.EmpCard.route
        ) {
           EmpCard(navController)

        }
        composable(
            route = Screens.EmpJob.route
        ) {
            EmpJob(navController)

        }


    }

}
