interface EmailServer {
    fun send(subjet: String, recepient: String, params:Array<String>)
}
