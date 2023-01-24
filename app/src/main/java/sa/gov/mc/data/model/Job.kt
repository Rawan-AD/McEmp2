package sa.gov.mc.data.model

data class Job(
    val id: Int,
    val title: String,
    val department: String,
    val location: String,
    val experience: String,
    val skills: String,
    val qualifications: String,
    val responsibilities: String,
    val specialization: String, val creationDate: String
)
