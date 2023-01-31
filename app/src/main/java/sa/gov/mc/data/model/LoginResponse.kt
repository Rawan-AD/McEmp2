package sa.gov.mc.data.model

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

data class LoginResponse(val requestId: Long, val uuid:String)