package io.code.morning

import software.amazon.awscdk.core.App
import software.amazon.awscdk.core.Environment
import software.amazon.awscdk.core.StackProps

fun main() {
    val app = App()

    HelloStack(app, "MySimpleLambda", "/build/distributions/aws-lambda-cdk-kotlin-1.0.0.zip")
    /*
    StackProps.builder()
        .env(
            Environment.builder()
                .account("515292396565")
                .region("ap-northeast-1")
                .build()
        )
        .build()
    )
     */

//    app.run()
    app.synth()
}