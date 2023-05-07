import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

// import com.google.android.gms.auth.api.signin.GoogleSignIn
// import com.google.android.gms.auth.api.signin.GoogleSignInClient
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions
// import com.google.auto.service.AutoService
import com.google.auto.service.AutoService

fun printHelloWorld() = println("Hello World!")

fun printGiphyTrendingResponse() {
    val giphyUrl = "https://api.giphy.com/v1/gifs/trending?api_key=M6KTSnNTQSOmxSJVpA9OX5eU0YYmkOVI&limit=25&rating=g"
    val client = OkHttpClient()
    val request = Request.Builder()
        .url(giphyUrl)
        .build()
    val response = client.newCall(request).execute()
    val jsonData = response.body?.string()
    val jsonObject = JSONObject(jsonData)
    println(jsonObject)
}

fun connectToWorkOrderEndpoint() {
    val baseUrl = "https://thermondo-backend-svmx-exit.herokuapp.com"
    val woUrl = "${baseUrl}/mobile/api/v3/work-orders"
    val myToken = "ya29.a0AX9GBdUoH83twbIIJIrY57OWJhduDcCFNXYxE6YtiJj9BoZduIDSQlaDgPH8jkom2SVn2cAXtt1bWyU2o7AxsxfE52J_RKgrJlTpElP_xykd-WCxskQ6odpIi8n3CRDwSoYzU3Pf5gstmeuiixw-n3io4gqK4-EaCgYKAQMSARASFQHUCsbCpzHLiyf5bpll4rYAYYQt9A0166"
    val client = OkHttpClient()
    val request = Request.Builder()
        .url(woUrl)
        .addHeader("Authorization", "Bearer $myToken")
        .build()
    val response = client.newCall(request).execute()
    println(response.code)

    if (response.code == 200) {
        val data = response.body?.string()
        println(data)
    }
}

/*fun getToken() {
    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestScopes(Scope("https://www.googleapis.com/auth/calendar"))
        .requestServerAuthCode("client_id_from_console")
        .build()
    // val googleSignInClient = GoogleSignIn.getClient(this, gso)
}*/

fun main(args: Array<String>) {
    printHelloWorld()
    printGiphyTrendingResponse()
    connectToWorkOrderEndpoint()
    getToken()
}