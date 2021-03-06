import React, {Component} from "react";
import CreateAccount from "./CreateAccount";
import AddBeneficiary from "./AddBeneficiary";
import RemoveBeneficiary from "./RemoveBeneficiary";
import Profile from "./Profile";
import TransferMoney from "./TransferMoney";
import ViewStatement from "./ViewStatement";

export default function CustomerFunctions({view}) {
    return (
        <div>
            {view === '1' ? <CreateAccount/> : ''}
            {view === '2' ? <AddBeneficiary/> : ''}
            {view === '3' ? <RemoveBeneficiary/> : ''}
            {view === '4' ? <TransferMoney/> : ''}
            {view === '5' ? <ViewStatement/> : ''}
            {view === '6' ? <Profile/> : ''}
        </div>
    )
}