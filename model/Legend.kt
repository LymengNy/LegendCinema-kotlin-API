package com.example.yujie.model

data class CinemaItem(
    val imageUrl: String,
    val location: String,
    val title: String

)

val cinemaItems = listOf(
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000009",
        location = "Legend K Mall",
        title = "2nd floor, K Mall"
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000006",
        location = "Legend Meanchey",
        title = "3rd Floor of New Steung Mean Chey market"
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000008",
        location = "Legend Midtown Mall",
        title = "1st Floor Midtown Mall"
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000013",
        location = "Legend Chipmong 271 ",
        title = "3rd Floor, Chip Mong Mega Mall"
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000011",
        location = "Legend Olympia",
        title = "6th Floor,The Olympia Mall"
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000014",
        location = "Legend Eden",
        title = "City Center Boulevard, Sangkat Srah Chak"
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000007",
        location = "Legend Noro Mall",
        title = "5th floor, Chip Mong Noro Mall"
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000004",
        location = "Legend Toul Kork",
        title = "TK Avenue Mall, Street 315"
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000005",
        location = "Legend Exchange Square",
        title = "Street 106, Corner of Street 61"
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000010",
        location = "Legend SenSok",
        title = "4th Floor, Chip Mong SenSok Mal"
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000012",
        location = "Legend Cinema Sihanoukville",
        title = "PGB-5-021, 4th Floor of Prince"
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000001",
        location = "Legend Siem Reap",
        title = "Level 3, The Heritage Walk, Corner of National Road 6 and Oum Chhay Street"
    )
)
