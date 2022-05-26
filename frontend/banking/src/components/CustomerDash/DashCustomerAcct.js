import React, {Component} from 'react';
import {
    MDBBtn,
    MDBCol, MDBContainer,
    MDBRow,
    MDBSwitch
} from "mdb-react-ui-kit";

class DashCustomerAcct extends Component {
    render() {
        return (
            <MDBContainer id='bg-glass' className='py-3 rounded-5 col-10'>
                <MDBRow className='mb-2'>
                    <MDBCol>
                            Account Type:
                    </MDBCol>
                </MDBRow>

                <MDBRow className='mb-2'>
                    <MDBCol>
                        Balance:
                    </MDBCol>
                </MDBRow>
                <MDBRow className='d-flex justify-content-center mt-4'>
                    <MDBCol className='col-5'>
                        <MDBSwitch label='Disable/Enable' defaultChecked />
                    </MDBCol>
                    <MDBCol className='col-4'>
                        <MDBBtn type='submit' size='sm'>View More</MDBBtn>
                    </MDBCol>
                </MDBRow>
            </MDBContainer>
        );
    }
}

export default DashCustomerAcct;