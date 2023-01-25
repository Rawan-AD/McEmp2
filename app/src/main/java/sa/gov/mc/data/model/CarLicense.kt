package sa.gov.mc.data.model

data class CarLicense(val id: Int,
  val  carTypeName: String,
val carCategory: String,
val carColor: String,
val carModel: String,
val platNumber: String,
val permissionNumber: Int,
val permissionDate: String,
val permitRequestDate: String,
val accepted: Int,
val empBuilding: String,
val requestStatus: String,
val requesterName: String,
val requestPhoneNumber: String,
val requesterUserName: String,
val requesterEmail: String,
val requesterDepartment: String)
