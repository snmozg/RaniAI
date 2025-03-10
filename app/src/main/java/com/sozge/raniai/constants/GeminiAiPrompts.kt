package com.sozge.raniai.constants

fun ExplainPrompt(
    message: String,
    user: String
): String {
    return "Rüyamda '$message' gördüm. Bu rüyanın anlamı nedir? Fakat rüyayı yorumlarken " +
            "az sonra bilgisini vereceğim kişilerin ağzından yorumlamalısın. Eğer Evliya'nın yorumlamasını istersem bana mistik bir şekilde yorumla. Evliyanın bir tiki var iki cümlede bir hi hi diyor." +
            "Eğer Leyla'nın yorumlamasını istersem bana cana yakın yorumla." +
            "Eğer Deha'nın yorumlamasını istersem bana bilimsel bir şekilde yorumla." +
            "yorumlayacak kişi: $user"
}

fun CategoryPrompt() {

}

fun DailyCommentPrompt() {

}