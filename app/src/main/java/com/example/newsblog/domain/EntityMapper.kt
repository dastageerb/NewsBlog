package com.example.newsblog.domain

interface EntityMapper <RESPONSE,REMOTE_ENTITY,MODEL> {

    fun mapResponseToListOfModel(response: RESPONSE):List<MODEL>
    fun mapResponseToModel(remoteEntity: REMOTE_ENTITY):MODEL
}