import axios from "axios";
import { toast } from "@/helpers/toast/toast.js";
import th from "@/helpers/toast/toastsHandler.js";
import("@/resources/css/toast.css");

// @ts-ignore
window.axios = axios;

// @ts-ignore
window.API_ENDPOINT = "http://localhost:3420/api";

// @ts-ignore
window.SERVER_ENDPOINT = "http://localhost:3420";

// @ts-ignore
window.toast = toast;

// @ts-ignore
window.toastjs = th;
