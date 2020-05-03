package pe.gob.msb.gp.enbici.data.source

interface DataBaseStorage {
    suspend fun getAll(): List<String>
    suspend fun isEmpty(): Boolean
}