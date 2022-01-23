fun main(args: Array<String>) {
    val seconds = 1260
    val result = agoToText(seconds)
    println("Был в сети $result")

}
fun agoToText(second: Int): String {
    val time: Int = second
    return when {
        (time in 0..60) -> "только что"
        (time in 61..60 * 60) -> checkMin(time)
        (time in 60 * 60 + 1..24 * 60 * 60) -> checkHour(time)
        (time in 24 * 60 * 60 + 1..48 * 60 * 60) -> "сегодня"
        (time in 48 * 60 * 60 + 1..72 * 60 * 60) -> "вчера"
        else -> "давно"
    }
}
fun checkMin(seconds: Int): String{
    val time = seconds / 60
    return if(time !in 11..20){
        when {
            (time % 10 == 1) -> "$time минуту назад"
            (time % 10 in 2..4) -> "$time минуты назад"
            (seconds == 3600) -> checkHour(seconds)
            else -> "$time минут назад"
        }
    } else "$time минут назад"
}
fun checkHour(seconds: Int): String{
    val time = seconds / 3600
    return when {
        (time == 1 || time == 21) -> "$time час назад"
        (time in 5..20) -> "$time часов назад"
        else -> "$time часа назад"
    }
}
