package com.example.todell.Database.Models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.util.*

/*** You define each Room entity as a class that is annotated with @Entity.
A Room entity includes fields for each column in the corresponding table in the database,
including one or more columns that comprise the primary key.
 **/

/***
 * The following code defines a ItemModel data entity.
 * Each instance of ItemModel represents a row in a ItemModel table in the app's database.
 * */
@Entity
data class TodellModel(
    val listTitle:String,
    /*
* Each Room entity must define a primary key that uniquely identifies each row in the corresponding database table.
* The most straightforward way of doing this is to annotate a single column with @PrimaryKey:
* */
    @PrimaryKey(autoGenerate = true)
    val listId: Int =0
)
@Entity
data class TodellModelTask(
    val taskTitle:String,
    val note:String,

    var dueDate: String?,

    val mainTaskId: Int,
    var completed: Boolean = false,
    var creationDate: String = Date().toString(),
    @PrimaryKey(autoGenerate = true)
    val taskId: Int = 0
)
data class MainTaskWithSubTask(
    @Embedded val task: TodellModel,
    @Relation(
        parentColumn = "listId",
        entityColumn = "mainTaskId"
    )
    val subTask: List<TodellModelTask>
)

