import React from 'react';
import { MDBCard, MDBCardImage, MDBCardBody, MDBCardTitle, MDBCardText, MDBCardLink, MDBListGroup, MDBListGroupItem } from 'mdb-react-ui-kit';
import './DashSideBar.css';

export default function DashSideBar() {
    return (
        <MDBCard id='bg-glass'>
            <MDBCardImage position='top' alt='...' src='https://iscdo.org/wp-content/uploads/2020/12/Article-04-HeaderImage-1130x650.jpg'/>
            <MDBCardBody>
                <MDBCardTitle>Dashboard</MDBCardTitle>
                <MDBCardText>
                    Account Info and Access.
                </MDBCardText>
            </MDBCardBody>
            <MDBListGroup flush>
                <MDBListGroupItem><MDBCardLink href='#'>Create Account</MDBCardLink></MDBListGroupItem>
                <MDBListGroupItem><MDBCardLink href='#'>Add Beneficiary</MDBCardLink></MDBListGroupItem>
                <MDBListGroupItem><MDBCardLink href='#'>Remove Beneficiary</MDBCardLink></MDBListGroupItem>
                <MDBListGroupItem><MDBCardLink href='#'>Transfer Funds</MDBCardLink></MDBListGroupItem>
                <MDBListGroupItem><MDBCardLink href='#'>View Statement</MDBCardLink></MDBListGroupItem>
            </MDBListGroup>
        </MDBCard>
    );
}