import logo from './logo.svg';
import './App.css';
import Landing from "./components/Landing/Landing";
import ForgotPassword from "./components/ForgotPassword/ForgotPassword";
import React from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import UpdatePassword from "./components/ForgotPassword/UpdatePassword";
import SecQuesMismatch from "./components/ForgotPassword/SecQuesMismatch";

function App() {
    return (
        <React.StrictMode>
            <BrowserRouter>
                {/*<Navigation/>*/}
                <Routes>
                    <Route path="/" element={<Landing/>}/>
                    <Route path="/questionAuth" element={<ForgotPassword/>}/>
                    <Route path="/updatePassword" element={<UpdatePassword/>}/>
                    <Route path="/infoMismatch" element={<SecQuesMismatch/>}/>
                    {/*<Route path="/help" element={<Help/>}/>*/}
                </Routes>
            </BrowserRouter>
        </React.StrictMode>
  );
}

export default App;
