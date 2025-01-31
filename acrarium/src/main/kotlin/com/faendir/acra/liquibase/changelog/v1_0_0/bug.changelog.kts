package com.faendir.acra.liquibase.changelog.v1_0_0

import com.faendir.acra.liquibase.changelog.Author
import com.faendir.acra.liquibase.changelog.ColumnType
import com.faendir.acra.liquibase.changelog.Table

databaseChangeLog {
    changeSet("1.0.0-create-bug", Author.F43ND1R) {
        createTable(Table.BUG) {
            column(name = "id", type = ColumnType.INT, autoIncrement = true) {
                constraints(nullable = false, primaryKey = true, primaryKeyName = "PK_bug")
            }
            column(name = "title", type = ColumnType.TEXT) {
                constraints(nullable = false)
            }
            column(name = "app_id", type = ColumnType.INT) {
                constraints(nullable = false, referencedTableName = Table.APP, referencedColumnNames = "id", deleteCascade = true, foreignKeyName = "FK_bug_app")
            }
            column(name = "solved_version", type = ColumnType.INT) {
                constraints(nullable = true, referencedTableName = Table.VERSION, referencedColumnNames = "id", foreignKeyName = "FK_bug_solved_version")
            }
        }
    }
}