package com.example.tugasakhir.view.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasakhir.R
import com.example.tugasakhir.ui.theme.TugasAkhirTheme

@Composable
fun SegmentText(
    title: String,
    modifier: Modifier = Modifier
){
    Text(
        text = title,
        style = MaterialTheme.typography.headlineSmall.copy(
            fontWeight = FontWeight.ExtraBold
        ),
        fontSize = 18.sp,
        modifier=modifier
            .padding(horizontal = 20.dp, vertical = 10.dp))
}

@Composable
@Preview(showBackground = true)
fun SegmentTextPreview(){
    TugasAkhirTheme{
        SegmentText(stringResource(id = R.string.section_menu))
    }
}