package com.example.authme2.model

data class NewJwtEntryRequest(var id: Int? = 112,
                              var jwt: String? = "12354568",
                              var user: String? = "test",
                                  var firstName: String? = "Matan",
                                  var secondName: String? = "Elbaz",
                                  var squad: String? = "Wonder",
                                  var tribe: String? = "Platform")

