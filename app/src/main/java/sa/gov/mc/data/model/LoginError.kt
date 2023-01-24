package sa.gov.mc.data.model

data class LoginError(  var errorCode: Int? = null,
                        var errorMessage: String? = null,
                        var errors: List<Error>? = null,)
