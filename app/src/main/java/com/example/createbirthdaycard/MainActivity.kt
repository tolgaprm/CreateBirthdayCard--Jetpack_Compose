package com.example.createbirthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.createbirthdaycard.ui.theme.CreateBirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MyApp {
             MyScreenContent()
           }
        }
    }
}

@Composable
fun MyApp(content:@Composable ()->Unit){
    CreateBirthdayCardTheme() {
        androidx.compose.material.Surface(modifier = Modifier.padding(horizontal = 8.dp,vertical = 5.dp)) {
            content()
        }
    }
}


@Composable
fun BirthdayCard(WhoBirthday:String,WhoIsCelebrating:String){
    Card {
        Image(
            painter = painterResource(id = R.drawable.androidparty),
            contentDescription =null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(shape = RoundedCornerShape(10.dp)),

            contentScale = ContentScale.Crop

        )
        Text(
            text ="Happy Birthday $WhoBirthday !",
            modifier = Modifier.padding(8.dp),
            fontSize = 25.sp,
            fontWeight = FontWeight.W500,
            fontFamily = FontFamily.SansSerif,
            maxLines = 1
        )
        
        Text(
            text = "By $WhoIsCelebrating",
            modifier = Modifier.padding(top = 210.dp,start = 260.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.W500,
            fontFamily = FontFamily.Serif,
            maxLines = 1
        )
        
    }

}

@Composable
fun Title(title:String){
    Surface(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 10.dp)
            .clip(RoundedCornerShape(10.dp)),
        color = Color(0x4B07B399)
        ) {
        Text(
            text = title,
            fontSize = 45.sp,
            modifier = Modifier.padding(12.dp),
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Cursive,

        )
    }

}




@Composable
fun MyScreenContent(){
    var WhoBirthday by remember { mutableStateOf("")}
    var WhoIsCelebrating by remember { mutableStateOf("")}

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Title(title ="Happy Birthday Card")

        BirthdayCard(WhoBirthday = WhoBirthday, WhoIsCelebrating = WhoIsCelebrating)

        OutlinedTextField(
            value = WhoBirthday,
            onValueChange ={ WhoBirthday = it },
            label ={ Text(text = "Who is Birthday")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp)
        )

        OutlinedTextField(
            value = WhoIsCelebrating,
            onValueChange ={WhoIsCelebrating=it},
            label = { Text(text = "Who is Celebrating")},
            modifier = Modifier.fillMaxWidth()
        )


    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
   MyApp {
       MyScreenContent( )
   }
}