package io.appwrite.services
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import okhttp3.Cookie
import okhttp3.Response
import java.io.File

class Databases(client: Client) : Service(client) {

    /**
     * List Databases
     *
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param limit Maximum number of collection to return in response. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Offset value. The default value is 0. Use this param to manage pagination. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param cursor ID of the collection used as the starting point for the query, excluding the collection itself. Should be used for efficient pagination when working with large sets of data.
     * @param cursorDirection Direction of the cursor.
     * @param orderType Order result by ASC or DESC order.
     * @return [io.appwrite.models.CollectionList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
		search: String? = null,
		limit: Long? = null,
		offset: Long? = null,
		cursor: String? = null,
		cursorDirection: String? = null,
		orderType: String? = null
	): io.appwrite.models.CollectionList {
        val path = "/databases"
        val params = mutableMapOf<String, Any?>(
            "search" to search,
            "limit" to limit,
            "offset" to offset,
            "cursor" to cursor,
            "cursorDirection" to cursorDirection,
            "orderType" to orderType
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.CollectionList = {
            io.appwrite.models.CollectionList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.CollectionList::class.java,
            converter,
        )
    }
    
    /**
     * Create Database
     *
     * @param databaseId Unique Id. Choose your own unique ID or pass the string &quot;unique()&quot; to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can&#039;t start with a special char. Max length is 36 chars.
     * @param name Collection name. Max length: 128 chars.
     * @return [io.appwrite.models.Database]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun create(
		databaseId: String,
		name: String
	): io.appwrite.models.Database {
        val path = "/databases"
        val params = mutableMapOf<String, Any?>(
            "databaseId" to databaseId,
            "name" to name
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Database = {
            io.appwrite.models.Database.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Database::class.java,
            converter,
        )
    }
    
    /**
     * Get Database
     *
     * @param databaseId Database ID.
     * @return [io.appwrite.models.Collection]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun get(
		databaseId: String
	): io.appwrite.models.Collection {
        val path = "/databases/{databaseId}".replace("{databaseId}", databaseId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Collection = {
            io.appwrite.models.Collection.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Collection::class.java,
            converter,
        )
    }
    
    /**
     * Update Database
     *
     * @param databaseId Database ID.
     * @param name Collection name. Max length: 128 chars.
     * @return [io.appwrite.models.Collection]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun update(
		databaseId: String,
		name: String
	): io.appwrite.models.Collection {
        val path = "/databases/{databaseId}".replace("{databaseId}", databaseId)
        val params = mutableMapOf<String, Any?>(
            "name" to name
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Collection = {
            io.appwrite.models.Collection.from(map = it)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Collection::class.java,
            converter,
        )
    }
    
    /**
     * Delete Database
     *
     * @param databaseId Database ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun delete(
		databaseId: String
	): Any {
        val path = "/databases/{databaseId}".replace("{databaseId}", databaseId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "DELETE",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * List Collections
     *
     * @param databaseId Database ID.
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param limit Maximum number of collection to return in response. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Offset value. The default value is 0. Use this param to manage pagination. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param cursor ID of the collection used as the starting point for the query, excluding the collection itself. Should be used for efficient pagination when working with large sets of data.
     * @param cursorDirection Direction of the cursor.
     * @param orderType Order result by ASC or DESC order.
     * @return [io.appwrite.models.CollectionList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listCollections(
		databaseId: String,
		search: String? = null,
		limit: Long? = null,
		offset: Long? = null,
		cursor: String? = null,
		cursorDirection: String? = null,
		orderType: String? = null
	): io.appwrite.models.CollectionList {
        val path = "/databases/{databaseId}/collections".replace("{databaseId}", databaseId)
        val params = mutableMapOf<String, Any?>(
            "search" to search,
            "limit" to limit,
            "offset" to offset,
            "cursor" to cursor,
            "cursorDirection" to cursorDirection,
            "orderType" to orderType
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.CollectionList = {
            io.appwrite.models.CollectionList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.CollectionList::class.java,
            converter,
        )
    }
    
    /**
     * Create Collection
     *
     * @param databaseId Database ID.
     * @param collectionId Unique Id. Choose your own unique ID or pass the string &quot;unique()&quot; to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can&#039;t start with a special char. Max length is 36 chars.
     * @param name Collection name. Max length: 128 chars.
     * @param permission Specifies the permissions model used in this collection, which accepts either &#039;collection&#039; or &#039;document&#039;. For &#039;collection&#039; level permission, the permissions specified in read and write params are applied to all documents in the collection. For &#039;document&#039; level permissions, read and write permissions are specified in each document. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @param read An array of strings with read permissions. By default no user is granted with any read permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @param write An array of strings with write permissions. By default no user is granted with any write permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @return [io.appwrite.models.Collection]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createCollection(
		databaseId: String,
		collectionId: String,
		name: String,
		permission: String,
		read: List<Any>,
		write: List<Any>
	): io.appwrite.models.Collection {
        val path = "/databases/{databaseId}/collections".replace("{databaseId}", databaseId)
        val params = mutableMapOf<String, Any?>(
            "collectionId" to collectionId,
            "name" to name,
            "permission" to permission,
            "read" to read,
            "write" to write
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Collection = {
            io.appwrite.models.Collection.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Collection::class.java,
            converter,
        )
    }
    
    /**
     * Get Collection
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @return [io.appwrite.models.Collection]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getCollection(
		databaseId: String,
		collectionId: String
	): io.appwrite.models.Collection {
        val path = "/databases/{databaseId}/collections/{collectionId}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Collection = {
            io.appwrite.models.Collection.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Collection::class.java,
            converter,
        )
    }
    
    /**
     * Update Collection
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param name Collection name. Max length: 128 chars.
     * @param permission Permissions type model to use for reading documents in this collection. You can use collection-level permission set once on the collection using the `read` and `write` params, or you can set document-level permission where each document read and write params will decide who has access to read and write to each document individually. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @param read An array of strings with read permissions. By default inherits the existing read permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @param write An array of strings with write permissions. By default inherits the existing write permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @param enabled Is collection enabled?
     * @return [io.appwrite.models.Collection]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateCollection(
		databaseId: String,
		collectionId: String,
		name: String,
		permission: String,
		read: List<Any>? = null,
		write: List<Any>? = null,
		enabled: Boolean? = null
	): io.appwrite.models.Collection {
        val path = "/databases/{databaseId}/collections/{collectionId}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "name" to name,
            "permission" to permission,
            "read" to read,
            "write" to write,
            "enabled" to enabled
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Collection = {
            io.appwrite.models.Collection.from(map = it)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Collection::class.java,
            converter,
        )
    }
    
    /**
     * Delete Collection
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteCollection(
		databaseId: String,
		collectionId: String
	): Any {
        val path = "/databases/{databaseId}/collections/{collectionId}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "DELETE",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * List Attributes
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @return [io.appwrite.models.AttributeList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listAttributes(
		databaseId: String,
		collectionId: String
	): io.appwrite.models.AttributeList {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.AttributeList = {
            io.appwrite.models.AttributeList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeList::class.java,
            converter,
        )
    }
    
    /**
     * Create Boolean Attribute
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeBoolean]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createBooleanAttribute(
		databaseId: String,
		collectionId: String,
		key: String,
		required: Boolean,
		default: Boolean? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeBoolean {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/boolean".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.AttributeBoolean = {
            io.appwrite.models.AttributeBoolean.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeBoolean::class.java,
            converter,
        )
    }
    
    /**
     * Create Email Attribute
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeEmail]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createEmailAttribute(
		databaseId: String,
		collectionId: String,
		key: String,
		required: Boolean,
		default: String? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeEmail {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/email".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.AttributeEmail = {
            io.appwrite.models.AttributeEmail.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeEmail::class.java,
            converter,
        )
    }
    
    /**
     * Create Enum Attribute
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Attribute Key.
     * @param elements Array of elements in enumerated type. Uses length of longest element to determine size. Maximum of 100 elements are allowed, each 4096 characters long.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeEnum]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createEnumAttribute(
		databaseId: String,
		collectionId: String,
		key: String,
		elements: List<Any>,
		required: Boolean,
		default: String? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeEnum {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/enum".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "elements" to elements,
            "required" to required,
            "default" to default,
            "array" to array
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.AttributeEnum = {
            io.appwrite.models.AttributeEnum.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeEnum::class.java,
            converter,
        )
    }
    
    /**
     * Create Float Attribute
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param min Minimum value to enforce on new documents
     * @param max Maximum value to enforce on new documents
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeFloat]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createFloatAttribute(
		databaseId: String,
		collectionId: String,
		key: String,
		required: Boolean,
		min: Double? = null,
		max: Double? = null,
		default: Double? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeFloat {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/float".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "min" to min,
            "max" to max,
            "default" to default,
            "array" to array
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.AttributeFloat = {
            io.appwrite.models.AttributeFloat.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeFloat::class.java,
            converter,
        )
    }
    
    /**
     * Create Integer Attribute
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param min Minimum value to enforce on new documents
     * @param max Maximum value to enforce on new documents
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeInteger]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createIntegerAttribute(
		databaseId: String,
		collectionId: String,
		key: String,
		required: Boolean,
		min: Long? = null,
		max: Long? = null,
		default: Long? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeInteger {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/integer".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "min" to min,
            "max" to max,
            "default" to default,
            "array" to array
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.AttributeInteger = {
            io.appwrite.models.AttributeInteger.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeInteger::class.java,
            converter,
        )
    }
    
    /**
     * Create IP Address Attribute
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeIp]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createIpAttribute(
		databaseId: String,
		collectionId: String,
		key: String,
		required: Boolean,
		default: String? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeIp {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/ip".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.AttributeIp = {
            io.appwrite.models.AttributeIp.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeIp::class.java,
            converter,
        )
    }
    
    /**
     * Create String Attribute
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Attribute Key.
     * @param size Attribute size for text attributes, in number of characters.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeString]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createStringAttribute(
		databaseId: String,
		collectionId: String,
		key: String,
		size: Long,
		required: Boolean,
		default: String? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeString {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/string".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "size" to size,
            "required" to required,
            "default" to default,
            "array" to array
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.AttributeString = {
            io.appwrite.models.AttributeString.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeString::class.java,
            converter,
        )
    }
    
    /**
     * Create URL Attribute
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeUrl]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createUrlAttribute(
		databaseId: String,
		collectionId: String,
		key: String,
		required: Boolean,
		default: String? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeUrl {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/url".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.AttributeUrl = {
            io.appwrite.models.AttributeUrl.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeUrl::class.java,
            converter,
        )
    }
    
    /**
     * Get Attribute
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Attribute Key.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getAttribute(
		databaseId: String,
		collectionId: String,
		key: String
	): Any {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/{key}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId).replace("{key}", key)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * Delete Attribute
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Attribute Key.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteAttribute(
		databaseId: String,
		collectionId: String,
		key: String
	): Any {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/{key}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId).replace("{key}", key)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "DELETE",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * List Documents
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/database#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param limit Maximum number of documents to return in response. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Offset value. The default value is 0. Use this value to manage pagination. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param cursor ID of the document used as the starting point for the query, excluding the document itself. Should be used for efficient pagination when working with large sets of data. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param cursorDirection Direction of the cursor.
     * @param orderAttributes Array of attributes used to sort results. Maximum of 100 order attributes are allowed, each 4096 characters long.
     * @param orderTypes Array of order directions for sorting attribtues. Possible values are DESC for descending order, or ASC for ascending order. Maximum of 100 order types are allowed.
     * @return [io.appwrite.models.DocumentList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listDocuments(
		databaseId: String,
		collectionId: String,
		queries: List<Any>? = null,
		limit: Long? = null,
		offset: Long? = null,
		cursor: String? = null,
		cursorDirection: String? = null,
		orderAttributes: List<Any>? = null,
		orderTypes: List<Any>? = null
	): io.appwrite.models.DocumentList {
        val path = "/databases/{databaseId}/collections/{collectionId}/documents".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "queries" to queries,
            "limit" to limit,
            "offset" to offset,
            "cursor" to cursor,
            "cursorDirection" to cursorDirection,
            "orderAttributes" to orderAttributes,
            "orderTypes" to orderTypes
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.DocumentList = {
            io.appwrite.models.DocumentList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.DocumentList::class.java,
            converter,
        )
    }
    
    /**
     * Create Document
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection). Make sure to define attributes before creating documents.
     * @param documentId Document ID. Choose your own unique ID or pass the string &quot;unique()&quot; to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can&#039;t start with a special char. Max length is 36 chars.
     * @param data Document data as JSON object.
     * @param read An array of strings with read permissions. By default only the current user is granted with read permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @param write An array of strings with write permissions. By default only the current user is granted with write permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @return [io.appwrite.models.Document]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createDocument(
		databaseId: String,
		collectionId: String,
		documentId: String,
		data: Any,
		read: List<Any>? = null,
		write: List<Any>? = null
	): io.appwrite.models.Document {
        val path = "/databases/{databaseId}/collections/{collectionId}/documents".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "documentId" to documentId,
            "data" to data,
            "read" to read,
            "write" to write
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Document = {
            io.appwrite.models.Document.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Document::class.java,
            converter,
        )
    }
    
    /**
     * Get Document
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param documentId Document ID.
     * @return [io.appwrite.models.Document]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getDocument(
		databaseId: String,
		collectionId: String,
		documentId: String
	): io.appwrite.models.Document {
        val path = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId).replace("{documentId}", documentId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Document = {
            io.appwrite.models.Document.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Document::class.java,
            converter,
        )
    }
    
    /**
     * Update Document
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param data Document data as JSON object. Include only attribute and value pairs to be updated.
     * @param read An array of strings with read permissions. By default inherits the existing read permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @param write An array of strings with write permissions. By default inherits the existing write permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @return [io.appwrite.models.Document]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateDocument(
		databaseId: String,
		collectionId: String,
		documentId: String,
		data: Any,
		read: List<Any>? = null,
		write: List<Any>? = null
	): io.appwrite.models.Document {
        val path = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId).replace("{documentId}", documentId)
        val params = mutableMapOf<String, Any?>(
            "data" to data,
            "read" to read,
            "write" to write
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Document = {
            io.appwrite.models.Document.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Document::class.java,
            converter,
        )
    }
    
    /**
     * Delete Document
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param documentId Document ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteDocument(
		databaseId: String,
		collectionId: String,
		documentId: String
	): Any {
        val path = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId).replace("{documentId}", documentId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "DELETE",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * List Indexes
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @return [io.appwrite.models.IndexList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listIndexes(
		databaseId: String,
		collectionId: String
	): io.appwrite.models.IndexList {
        val path = "/databases/{databaseId}/collections/{collectionId}/indexes".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.IndexList = {
            io.appwrite.models.IndexList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.IndexList::class.java,
            converter,
        )
    }
    
    /**
     * Create Index
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Index Key.
     * @param type Index type.
     * @param attributes Array of attributes to index. Maximum of 100 attributes are allowed, each 32 characters long.
     * @param orders Array of index orders. Maximum of 100 orders are allowed.
     * @return [io.appwrite.models.Index]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createIndex(
		databaseId: String,
		collectionId: String,
		key: String,
		type: String,
		attributes: List<Any>,
		orders: List<Any>? = null
	): io.appwrite.models.Index {
        val path = "/databases/{databaseId}/collections/{collectionId}/indexes".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "type" to type,
            "attributes" to attributes,
            "orders" to orders
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Index = {
            io.appwrite.models.Index.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Index::class.java,
            converter,
        )
    }
    
    /**
     * Get Index
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Index Key.
     * @return [io.appwrite.models.Index]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getIndex(
		databaseId: String,
		collectionId: String,
		key: String
	): io.appwrite.models.Index {
        val path = "/databases/{databaseId}/collections/{collectionId}/indexes/{key}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId).replace("{key}", key)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Index = {
            io.appwrite.models.Index.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Index::class.java,
            converter,
        )
    }
    
    /**
     * Delete Index
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Index Key.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteIndex(
		databaseId: String,
		collectionId: String,
		key: String
	): Any {
        val path = "/databases/{databaseId}/collections/{collectionId}/indexes/{key}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId).replace("{key}", key)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "DELETE",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
}