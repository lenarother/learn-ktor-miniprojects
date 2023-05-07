# Ktor architecture

* EngineMain.main -> start application
* ApplicationEngine
  * ApplicationEngineEnvironment
  * ApplicationCallPipeline
    * Features go here
    * Application call -> request, response, parameters, attributes