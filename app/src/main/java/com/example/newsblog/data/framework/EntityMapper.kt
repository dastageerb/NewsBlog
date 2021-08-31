package com.example.newsblog.data.framework

interface EntityMapper<Entity,Model>
{

    fun mapToModel(entity: Entity):Model


}