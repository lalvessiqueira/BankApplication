import React, {useState} from 'react';
import { MDBCard, MDBCardImage, MDBCardBody, MDBCardTitle, MDBCardText, MDBCardLink, MDBListGroup, MDBListGroupItem } from 'mdb-react-ui-kit';
import './DashSideBar.css';
import CustomerFunctions from "../CustomerDash/CustomerFunctions/CustomerFunctions";
import CreateAccount from "./CustomerFunctions/CreateAccount";
import AddBeneficiary from "./CustomerFunctions/AddBeneficiary";

export default function DashSideBar({setView}) {

    const onButtonClick = (view) => {
        setView(view)
    }

    return (
        <div>
            <MDBCard id='bg-glass'>
                <MDBCardImage position='top' alt='...' src='https://iscdo.org/wp-content/uploads/2020/12/Article-04-HeaderImage-1130x650.jpg'/>
                <MDBCardBody>
                    <MDBCardTitle>
                        <MDBCardLink href='#' onClick={()=>onButtonClick('0')}>Dashboard</MDBCardLink>
                    </MDBCardTitle>
                    <MDBCardText>
                        Account Info and Access.
                    </MDBCardText>
                </MDBCardBody>
                <MDBListGroup flush>
                    <MDBListGroupItem><MDBCardLink href='#' onClick={()=>onButtonClick('1')}>Create Account</MDBCardLink></MDBListGroupItem>
                    <MDBListGroupItem><MDBCardLink href='#' onClick={()=>onButtonClick('2')}>Add Beneficiary</MDBCardLink></MDBListGroupItem>
                    <MDBListGroupItem><MDBCardLink href='#' onClick={()=>onButtonClick('3')}>Remove Beneficiary</MDBCardLink></MDBListGroupItem>
                    <MDBListGroupItem><MDBCardLink href='#' onClick={()=>onButtonClick('4')}>Transfer Funds</MDBCardLink></MDBListGroupItem>
                    <MDBListGroupItem><MDBCardLink href='#' onClick={()=>onButtonClick('5')}>View Statement</MDBCardLink></MDBListGroupItem>
                </MDBListGroup>
            </MDBCard>
        </div>


    );
}