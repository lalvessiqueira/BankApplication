import React, {Component} from "react";
import CreateAccount from "./CreateAccount";
import AddBeneficiary from "./AddBeneficiary";
import RemoveBeneficiary from "./RemoveBeneficiary";
import Profile from "./Profile";
import TransferMoney from "./TransferMoney";
import ViewStatement from "./ViewStatement";

export default function ProfileWarning() {
    return (
        <div>
            <h1>Please fill out profile information!</h1>
        </div>
    )
}