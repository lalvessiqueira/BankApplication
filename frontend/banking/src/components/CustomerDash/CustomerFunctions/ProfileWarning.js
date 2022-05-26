import React, {Component} from "react";


export default function ProfileWarning() {
    return (
        <div className="alert alert-success alert-dismissible fade show" role="alert">
            <strong>Suggestion!</strong> Update the info in your PROFILE to access more features.
            <button type="button" className="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    )
}