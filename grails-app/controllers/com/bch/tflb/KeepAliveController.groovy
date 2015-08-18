package com.bch.tflb

class KeepAliveController {

    /**
     * Renders a 200 reponse to tell the client the server session is still alive. If the session expired the security framework should intervene with a login request
     */
    def index() {
        render (status: 200, text:"User session is alive.")
    }
}
