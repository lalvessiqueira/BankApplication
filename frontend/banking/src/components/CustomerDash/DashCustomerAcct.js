import React, {Component} from 'react';
import {
    MDBBtn,
    MDBCol, MDBContainer,
    MDBRow,
    MDBSwitch
} from "mdb-react-ui-kit";
import axios from "axios";

class DashCustomerAcct extends Component {
    constructor(props) {
        super(props);
        this.state = {
            accounts: [],
            moreaccounts: [],
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8081/api/customer/username/" + localStorage.getItem("username"))
            .then((response) => {
                this.setState({accounts: response.data.accounts[0]})
                this.setState({moreaccounts: response.data.accounts})
            })
            .catch((error) => {
                console.log(error)
            });
    }

    render() {
        return (
            <div>
                {this.state.moreaccounts?.map(account =>
                    <MDBContainer id='bg-glass' className='py-3 rounded-5 col-10 my-3'>
                        {/*<h1>HEY</h1>*/}
                        <MDBRow className='mb-2'>
                            <MDBCol>
                                Account Type: {account.accountType}
                            </MDBCol>
                        </MDBRow>

                        <MDBRow className='mb-2'>
                            <MDBCol>
                                Balance: {account.accountBalance}
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
                    )}
            </div>


            // <div>

            // </div>
        );
    }
}

export default DashCustomerAcct;