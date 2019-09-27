# Jira Stub

An open source Jira stub for Jira Server.

Currently has end points for GET requests to:
 - /user
 - /search 
 - /issue/[key]

## 1. Running locally

## 1.1 Prerequisites

The below is required to be installed for the Jira stub to run locally:

1. Java 8
2. Gradle `brew install gradle` with MacOS

## 1.2 Running development services locally

1. Build app and install dependencies with `gradle clean build`, or setup your IDE to do this for you
2. Run the `main/src/JiraStub.kt` class in your preferred IDE
3. This will run the API locally on port `8081`

## 1.3 Request and Response Examples

#### Requests

* [GET /user](####GET-/user)
* [GET /search](####GET-/search)
* [GET /issue/[key]](####GET-/issue/[key])

#### GET /user


Example: http://localhost:8081/rest/api/2/user?username=tony

Response body:


    {
        "key": "tony",
        "name": "tony",
        "emailAddress": "tfoxbridge@gmail.com",
        "avatarUrls": {
            "48x48": "https://images.vexels.com/media/users/3/145908/preview2/52eabf633ca6414e60a7677b0b917d92-male-avatar-maker.jpg",
            "24x24": "https://images.vexels.com/media/users/3/145908/preview2/52eabf633ca6414e60a7677b0b917d92-male-avatar-maker.jpg",
            "16x16": "https://images.vexels.com/media/users/3/145908/preview2/52eabf633ca6414e60a7677b0b917d92-male-avatar-maker.jpg",
            "32x32": "https://images.vexels.com/media/users/3/145908/preview2/52eabf633ca6414e60a7677b0b917d92-male-avatar-maker.jpg"
        },
        "displayName": "Tony Foxbridge",
        "active": true
    }

---
    
 #### GET /search
 
Parameters:
* `jql` - is essential, if missing will throw 400 - Bad Request
* `maxResults` - if missing will default to 50
* `startAt` - if missing will default to 0

JQL: `key in (ABC-2111, ABC-2112) AND status NOT IN (Closed, Withdrawn)`

Example: http://localhost:8081/rest/api/2/search?jql=key%20in%20(ABC-2111,%20ABC-2112)%20AND%20status%20NOT%20IN%20(Closed,%20Withdrawn)

Response body:

    {
        "startAt": 0,
        "maxResults": 50,
        "total": 2,
        "issues": [
            {
                "key": "ABC-2111",
                "fields": {
                    "summary": "2111 Epic summary",
                    "status": {
                        "name": "Amazing"
                    },
                    "issuetype": {
                        "name": "Chore"
                    },
                    "customfield_10006": "ABC-6100",
                    "assignee": {
                        "displayName": "Tony Foxbridge"
                    },
                    "duedate": "2020-01-01"
                }
            },
            {
                "key": "ABC-2112",
                "fields": {
                    "summary": "2112 Epic summary",
                    "status": {
                        "name": "Amazing"
                    },
                    "issuetype": {
                        "name": "Chore"
                    },
                    "customfield_10006": "ABC-6101",
                    "assignee": {
                        "displayName": "Tony Foxbridge"
                    },
                    "duedate": "2020-01-01"
                }
            }
        ]
    }
---
    
JQL: `"Epic Link" = ABC-2111 AND status NOT IN (Closed, Withdrawn)`

Example: http://localhost:8081/rest/api/2/search?jql=%22Epic%20Link%22%20=%20ABC-2111%20AND%20status%20NOT%20IN%20(Closed,%20Withdrawn)

Response body:

    {
        "startAt": 0,
        "maxResults": 50,
        "total": 2,
        "issues": [
            {
                "key": "ABC-4001",
                "fields": {
                    "summary": "4001 summary",
                    "status": {
                        "name": "Amazing"
                    },
                    "issuetype": {
                        "name": "Chore"
                    },
                    "customfield_10006": "ABC-2111",
                    "assignee": {
                        "displayName": "Tony Foxbridge"
                    },
                    "duedate": "2020-01-01"
                }
            },
            {
                "key": "ABC-4002",
                "fields": {
                    "summary": "4002 summary",
                    "status": {
                        "name": "Amazing"
                    },
                    "issuetype": {
                        "name": "Chore"
                    },
                    "customfield_10006": "ABC-2111",
                    "assignee": {
                        "displayName": "Tony Foxbridge"
                    },
                    "duedate": "2020-01-01"
                }
            }
        ]
    }
---
Example: http://localhost:8081/rest/api/2/search?jql=%22Epic%20Link%22%20=%20ABC-2111%20AND%20status%20NOT%20IN%20(Closed,%20Withdrawn)&maxResults=40&startAt=10

Response body:

    {
        "startAt": 10,
        "maxResults": 40,
        "total": 2,
        "issues": [
            {
                "key": "ABC-4001",
                "fields": {
                    "summary": "4001 summary",
                    "status": {
                        "name": "Amazing"
                    },
                    "issuetype": {
                        "name": "Chore"
                    },
                    "customfield_10006": "ABC-2111",
                    "assignee": {
                        "displayName": "Tony Foxbridge"
                    },
                    "duedate": "2020-01-01"
                }
            },
            {
                "key": "ABC-4002",
                "fields": {
                    "summary": "4002 summary",
                    "status": {
                        "name": "Amazing"
                    },
                    "issuetype": {
                        "name": "Chore"
                    },
                    "customfield_10006": "ABC-2111",
                    "assignee": {
                        "displayName": "Tony Foxbridge"
                    },
                    "duedate": "2020-01-01"
                }
            }
        ]
    }
    
#### GET /issue/[key]
 
Parameters:
* `key` - is essential, if missing will throw 400 - Bad Request
* `expand` - if expand is present it will respond with changelog
    * `maxResults` - only used if expand is present, default is 50
    * `startAt` - only used if expand is present, default is 0

Example: http://localhost:8081/rest/api/2/issue/ABC-1111
 
Response body:
 
    {
        "key": "ABC-1111",
        "fields": {
            "issuelinks": [
                {
                    "type": {
                        "name": "Gant End to End",
                        "inward": "depends on"
                    },
                    "outwardIssue": {
                        "key": "ABC-2111",
                        "fields": {
                            "issuetype": {
                                "name": "Epic"
                            }
                        }
                    },
                    "inwardissue": {
                        "key": "ABC-2111",
                        "fields": {
                            "issuetype": {
                                "name": "Epic"
                            }
                        }
                    }
                },
                {
                    "type": {
                        "name": "Gant End to End",
                        "inward": "depends on"
                    },
                    "outwardIssue": {
                        "key": "ABC-2112",
                        "fields": {
                            "issuetype": {
                                "name": "Epic"
                            }
                        }
                    },
                    "inwardissue": {
                        "key": "ABC-2112",
                        "fields": {
                            "issuetype": {
                                "name": "Epic"
                            }
                        }
                    }
                }
            ]
        }
    }
---

Example: http://localhost:8081/rest/api/2/issue/ABC-2233?expand=changelog&maxResults=40&startAt=10

Response body:

    {
        "key": "ABC-2233",
        "changelog": {
            "startAt": 10,
            "maxResults": 40,
            "total": 1,
            "histories": [
                {
                    "created": "2019-12-25T20:00:00.000+0000",
                    "items": [
                        {
                            "field": "status",
                            "fromString": "Open",
                            "toString": "Closed"
                        }
                    ]
                }
            ]
        }
    }