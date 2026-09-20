package app.aeong.patches.twitch.stuff

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.string
import com.android.tools.smali.dexlib2.AccessFlags

internal object HomePageExperimentFingerprint : Fingerprint(
    accessFlags = listOf(
        AccessFlags.PUBLIC
    ),
    parameters = emptyList(),
    filters = listOf(
        string("home_page_experiment_variant"),
        string("control"),
        string("live"),
        string("following")
    )
)