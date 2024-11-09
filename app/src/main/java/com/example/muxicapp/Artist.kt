package com.example.muxicapp

data class Artist(
    val name: String,
    val imageUrl: String
)
val artists = listOf(
    Artist("justin Bieber", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOlssRUn17NILqB1GsXiwvLbMh4f0WQp6aq-hbv8uJHjExBTRl"),
    Artist("taylor Swift", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7iNOj7nd4xlFTLBkZUrVNWlznY-CY9Zq2sA&s"),
    Artist("drake", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQp4lC836enKpoOr92PDXKT7o7xegASn9yDNQ&s"),
    Artist("beyoncé", "https://media.glamour.com/photos/653ab2ea95ef332a27da5348/master/w_2560%2Cc_limit/1458274605"),
    Artist("adele", "https://upload.wikimedia.org/wikipedia/commons/5/52/Adele_for_Vogue_in_2021.png"),
    Artist("the Weeknd", "https://static.wikia.nocookie.net/singmovie/images/b/b5/The-Weeknd.jpg/revision/latest?cb=20220808010527"),
    Artist("ed Sheeran", "https://cdn.britannica.com/17/249617-050-4575AB4C/Ed-Sheeran-performs-Rockefeller-Plaza-Today-Show-New-York-2023.jpg"),
    Artist("bad Bunny", "https://www.rollingstone.com/wp-content/uploads/2023/10/Bad-Bunny-lawsuits.jpg"),
    Artist("billie Eilish", "https://assets.vogue.com/photos/609bb445758287e5e091eeed/4:3/w_1999,h_1499,c_limit/Billie-Eilish-Happier-Than-Ever.jpeg"),
    Artist("kendrick Lamar", "https://hiphophero.com/static/uploads/5/2024/07/Kendrick-Lamar-2024-Not-Like-Us-Hip-Hop-Hero.jpg")
)