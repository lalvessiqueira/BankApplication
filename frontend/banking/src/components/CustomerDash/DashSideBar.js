import React from 'react';
import { MDBCard, MDBCardImage, MDBCardBody, MDBCardTitle, MDBCardText, MDBCardLink, MDBListGroup, MDBListGroupItem } from 'mdb-react-ui-kit';

export default function DashSideBar() {
    return (
        <MDBCard style={{  color: 'black' }} id='bg-glass'>
            <MDBCardImage position='top' alt='...' src='https://iscdo.org/wp-content/uploads/2020/12/Article-04-HeaderImage-1130x650.jpg'/>
            <MDBCardBody>
                <MDBCardTitle>Dashboard</MDBCardTitle>
                <MDBCardText>
                    Account Info and Access.
                </MDBCardText>
            </MDBCardBody>
            <MDBListGroup flush>
                <MDBListGroupItem style={{background: "none"}}><MDBCardLink href='#'>Create Account</MDBCardLink></MDBListGroupItem>
                <MDBListGroupItem style={{background: "none"}}><MDBCardLink href='#'>Add Beneficiary</MDBCardLink></MDBListGroupItem>
                <MDBListGroupItem style={{background: "none"}}><MDBCardLink href='#'>Remove Beneficiary</MDBCardLink></MDBListGroupItem>
                <MDBListGroupItem style={{background: "none"}}><MDBCardLink href='#'>Transfer Funds</MDBCardLink></MDBListGroupItem>
                <MDBListGroupItem style={{background: "none"}}><MDBCardLink href='#'>View Statement</MDBCardLink></MDBListGroupItem>
            </MDBListGroup>
        </MDBCard>
    );
}