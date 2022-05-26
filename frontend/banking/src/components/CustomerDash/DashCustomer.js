import React, {useEffect, useState} from 'react';
import './DashCustomer.css';
import DashCustomerHeader from "./DashCustomerHeader";
import DashSideBar from "./DashSideBar";
import DashCustomerAcct from "./DashCustomerAcct";
import Footer from "../Landing/Footer";
import LandingCardGroup from "../Landing/LandingCardGroup";
import CustomerFunctions from "./CustomerFunctions/CustomerFunctions";
import axios from "axios";
import ProfileWarning from "./CustomerFunctions/ProfileWarning";

export default function DashCustomer({setIsLoggedIn}) {
    const [view, setView] = useState('0')
    const [profileEmpty, setProfileEmpty] = useState(true)

    useEffect(() => {
        axios.get("http://localhost:8081/api/customer/username/" + localStorage.getItem("username"))
            .then((response) => {
                if (response.data.secretQuestion == null ||
                    response.data.secretAnswer == null ||
                    response.data.phone == null ||
                    response.data.stateID == null ||
                    response.data.ssn == null) {
                    setProfileEmpty(true)
                } else {
                    console.log(response.data)
                    setProfileEmpty(false)
                }
            })
            .catch((error) => {
                console.log(error)
            });
    });

    return (
        <div className="container">
            <div className="row">
                <DashCustomerHeader setView={setView} setIsLoggedIn={setIsLoggedIn}/>
            </div>
            <div>
                <section>
                    <div className="row">
                        <div className="col-md-6 mb-3">
                            <DashSideBar setView={setView}/>
                        </div>
                        <div className="col mb-3" >
                            { profileEmpty ? <ProfileWarning/> : ""}
                            { (view === '0') ? <DashCustomerAcct/> : <CustomerFunctions view={view} /> }
                        </div>
                    </div>
                </section>
            </div>

            <div className="row my-5">
                <LandingCardGroup/>
            </div>
            <div className="row">
                <Footer/>
            </div>
        </div>
    );
}