package com.example.knownyc.presentation.parks

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.knownyc.R
import com.example.knownyc.commons.TAG
import com.example.knownyc.presentation.ui.util.LoadingDialog

@Composable
fun NycParksScreen(
    modifier: Modifier = Modifier,
    boroughCode: String,
) {
    val viewModel: NycParksViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel.setBoroughCode(boroughCode)
    }

    LoadingDialog(isLoading = state.isLoading)

    LazyColumn(
        modifier = modifier
    ) {
        items(state.parks){park ->
            NycParkCard(
                signname = park.signname,
                location = park.location,
                waterfront = park.waterfront,
                parksLogo = painterResource(id = R.drawable.nyc_parks_logo)
            ) {
                Log.d(TAG, "clicked: ${park.signname}")
//                openUrl(context, park.url)
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(park.url))
                context.startActivity(intent)
            }
        }
    }
}

