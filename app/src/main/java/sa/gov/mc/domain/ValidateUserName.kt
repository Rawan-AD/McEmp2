package sa.gov.mc.domain

class ValidateUserName {

    fun execute(userName:String?):ValidateResult{
        if(userName?.isBlank() == true){
            return ValidateResult(successful = false,
            errorMessage = "The username can't be blank")
        }
      return ValidateResult(successful = true,
      )

    }

}