package app.aeong.patches.twitch.stuff

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patcher.patch.stringOption

@Suppress("unused")
val openFollowingPatch = bytecodePatch(
    name = "Open Following by default",
    description = "set home_page_experiment_variant to following (for now)",
    default = true
) {
    compatibleWith(
        Compatibility(
            name = "Twitch",
            packageName = "tv.twitch.android.app",
            appIconColor = 0x9147FF,
            targets = listOf(
                AppTarget("30.7.2")
            )
        )
    )
    
    execute {
        val method = HomePageExperimentFingerprint.method
        val variantType = method.returnType

        method.addInstructions(
            0,
            """
                sget-object v0, $variantType->Following:$variantType
                return-object v0
            """
        )
    }
}