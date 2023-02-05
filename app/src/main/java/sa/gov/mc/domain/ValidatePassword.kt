package sa.gov.mc.domain

class ValidatePassword {

    fun execute(password:String?):ValidateResult{
        if(password?.isBlank()==true){
            return ValidateResult(successful = false,
                errorMessage = "The password can't be blank")
        }
        if(password?.length !!< 6){
            return ValidateResult(successful = false,
                errorMessage = "The password needd tp consist of at least 8 characters")
        }

        return ValidateResult(successful = true,
        )

    }
}