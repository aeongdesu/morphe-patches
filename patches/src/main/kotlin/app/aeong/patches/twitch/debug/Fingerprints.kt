package app.aeong.patches.twitch.debug

import app.morphe.patcher.Fingerprint
import com.android.tools.smali.dexlib2.AccessFlags

internal object VideoDebugConfigFingerprint : Fingerprint(
    classFingerprint = Fingerprint(
        strings = listOf("showVideoDebugPanel"),
    ),
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.FINAL),
    name = "shouldShowVideoDebugPanel",
    returnType = "Z",
    parameters = emptyList(),
)