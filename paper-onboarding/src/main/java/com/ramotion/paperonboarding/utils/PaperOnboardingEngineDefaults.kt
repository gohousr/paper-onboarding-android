package com.ramotion.paperonboarding.utils

/**
 * Default values for everything
 */
interface PaperOnboardingEngineDefaults {
  companion object {
    val TAG = "POB"

    // animation and view settings
    val ANIM_PAGER_BAR_MOVE_TIME = 700

    val ANIM_PAGER_ICON_TIME = 350

    val ANIM_BACKGROUND_TIME = 450

    val CONTENT_TEXT_POS_DELTA_Y_DP = 50
    val ANIM_CONTENT_TEXT_SHOW_TIME = 800
    val ANIM_CONTENT_TEXT_HIDE_TIME = 200

    val CONTENT_ICON_POS_DELTA_Y_DP = 50
    val ANIM_CONTENT_ICON_SHOW_TIME = 800
    val ANIM_CONTENT_ICON_HIDE_TIME = 200

    val PAGER_ICON_SHAPE_ALPHA = 0.5f

    val ANIM_CONTENT_CENTERING_TIME = 800
  }

}
