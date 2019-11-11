package io.code.morning

import software.amazon.awscdk.core.App
import software.amazon.awscdk.core.Duration
import software.amazon.awscdk.core.Stack
import software.amazon.awscdk.core.StackProps
import software.amazon.awscdk.services.lambda.Code
import software.amazon.awscdk.services.lambda.Function
import software.amazon.awscdk.services.lambda.FunctionProps
import software.amazon.awscdk.services.lambda.Runtime

class MyLambdaStack @JvmOverloads constructor(parent: App, id: String, localCodePath: String, props: StackProps? = null) :
    Stack(parent, id, props) {

    init {
        val functionProps = FunctionProps.builder()
            .runtime(Runtime.JAVA_8)
            .code(Code.fromAsset(System.getProperty("user.dir") + localCodePath))
            .handler("io.code.morning.FunctionSendSlackNotification")
            .functionName("FunctionSendSlackNotification")
            .memorySize(512)
            .timeout(Duration.seconds(10))
            .build()

        val function = Function(this, "FunctionSendSlackNotification", functionProps)
    }
}
