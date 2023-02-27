package edu.uksw.fti.pam.acitivityintent.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class TopNavItems(
    val title: String,
    val icon: ImageVector,
    val screen_route: String
) {
    object Menu: TopNavItems("Menu", Icons.Default.Menu, "Menu")
    object Akun: TopNavItems("Akun", Icons.Default.Person, "Akun")
    object Info: TopNavItems("Info", Icons.Default.Info, "Info")
}