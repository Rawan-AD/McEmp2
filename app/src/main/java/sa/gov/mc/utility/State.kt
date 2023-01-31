package sa.gov.mc.utility

import sa.gov.mc.data.model.LoginResponse

sealed class State{
    object Loading: State()
    object Empty: State()
    class Success(
        val data: LoginResponse): State()

    class Failure(
        val errorMessage: Throwable): State()
}