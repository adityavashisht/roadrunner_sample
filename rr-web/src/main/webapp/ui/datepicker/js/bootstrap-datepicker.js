/* =========================================================
 * bootstrap-datepicker.js
 * http://www.eyecon.ro/bootstrap-datepicker
 * =========================================================
 * Copyright 2012 Stefan Petre
 * Improvements by Andrew Rowls
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================= */

!function (e) {
    var m = function (a, b) {
        this.element = e(a);
        this.language = b.language || this.element.data("date-language") || "en";
        this.language = this.language in l ? this.language : "en";
        this.format = g.parseFormat(b.format || this.element.data("date-format") || "mm/dd/yyyy");
        this.picker = e(g.template).appendTo("body").on({click: e.proxy(this.click, this), mousedown: e.proxy(this.mousedown, this)});
        this.isInput = this.element.is("input");
        if ((this.component = this.element.is(".date") ? this.element.find(".add-on") : !1) && 0 === this.component.length)this.component = !1;
        if (this.isInput)this.element.on({focus: e.proxy(this.show, this), blur: e.proxy(this._hide, this), keyup: e.proxy(this.update, this), keydown: e.proxy(this.keydown, this)}); else if (this.component)this.component.on("click", e.proxy(this.show, this)), a = this.element.find("input"), a.on({blur: e.proxy(this._hide, this)}); else this.element.on("click", e.proxy(this.show, this));
        this.autoclose = !1;
        "autoclose"in b ? this.autoclose = b.autoclose : "dateAutoclose"in this.element.data() && (this.autoclose = this.element.data("date-autoclose"));
        switch (b.startView) {
            case 2:
            case "decade":
                this.viewMode = this.startViewMode = 2;
                break;
            case 1:
            case "year":
                this.viewMode = this.startViewMode = 1;
                break;
            default:
                this.viewMode = this.startViewMode = 0
        }
        this.weekStart = (b.weekStart || this.element.data("date-weekstart") || l[this.language].weekStart || 0) % 7;
        this.weekEnd = (this.weekStart + 6) % 7;
        this.startDate = -Infinity;
        this.endDate = Infinity;
        this.setStartDate(b.startDate || this.element.data("date-startdate"));
        this.setEndDate(b.endDate || this.element.data("date-enddate"));
        this.fillDow();
        this.fillMonths();
        this.update();
        this.showMode()
    };
    m.prototype = {constructor: m, show: function (a) {
        this.picker.show();
        this.height = this.component ? this.component.outerHeight() : this.element.outerHeight();
        this.place();
        e(window).on("resize", e.proxy(this.place, this));
        a && (a.stopPropagation(), a.preventDefault());
        if (!this.isInput)e(document).on("mousedown", e.proxy(this.hide, this));
        this.element.trigger({type: "show", date: this.date})
    }, _hide: function (a) {
        if (e.browser!=undefined && e.browser.msie) {
            var b = this, c = arguments, f = function () {
                clearTimeout(j);
                a.target.focus();
                b.picker.off("click", f)
            };
            this.picker.on("click", f);
            var j = setTimeout(function () {
                b.hide.apply(b, c);
                b.picker.off("click", f)
            }, 100)
        } else return this.hide.apply(this, arguments)
    }, hide: function (a) {
        this.picker.hide();
        e(window).off("resize", this.place);
        this.viewMode = this.startViewMode;
        this.showMode();
        this.isInput || e(document).off("mousedown", this.hide);
        a && a.currentTarget.value && this.setValue();
        this.element.trigger({type: "hide", date: this.date})
    }, setValue: function () {
        var a = g.formatDate(this.date, this.format, this.language);
        this.isInput ? this.element.prop("value", a) : (this.component && this.element.find("input").prop("value", a), this.element.data("date", a))
    }, setStartDate: function (a) {
        this.startDate = a || -Infinity;
        -Infinity !== this.startDate && (this.startDate = g.parseDate(this.startDate, this.format, this.language));
        this.update();
        this.updateNavArrows()
    }, setEndDate: function (a) {
        this.endDate = a || Infinity;
        Infinity !== this.endDate && (this.endDate = g.parseDate(this.endDate, this.format, this.language));
        this.update();
        this.updateNavArrows()
    }, place: function () {
        var a = this.component ? this.component.offset() : this.element.offset(), b = e(window).width() - a.left, c = this.component ? this.component.outerWidth() : 0;
        208 > b ? this.picker.addClass("dp_right").css({top: a.top + this.height, right: b - c, left: "auto"}) : this.picker.css({top: a.top + this.height, left: a.left})
    }, update: function () {
        this.date = g.parseDate(this.isInput ? this.element.prop("value") : this.element.data("date"), this.format, this.language);
        this.viewDate = this.date < this.startDate ? new Date(this.startDate) : this.date > this.endDate ? new Date(this.endDate) : new Date(this.date);
        this.fill()
    }, fillDow: function () {
        for (var a = this.weekStart, b = "<tr>"; a < this.weekStart + 7;)b += '<th class="dow">' + l[this.language].daysMin[a++ % 7] + "</th>";
        this.picker.find(".datepicker-days thead").append(b + "</tr>")
    }, fillMonths: function () {
        for (var a = "", b = 0; 12 > b;)a += '<span class="month">' + l[this.language].monthsShort[b++] + "</span>";
        this.picker.find(".datepicker-months td").html(a)
    }, fill: function () {
        var a = new Date(this.viewDate), b = a.getFullYear(), c = a.getMonth(), a = -Infinity !== this.startDate ? this.startDate.getFullYear() : -Infinity, f = -Infinity !== this.startDate ? this.startDate.getMonth() : -Infinity, e = Infinity !== this.endDate ? this.endDate.getFullYear() : Infinity, i = Infinity !== this.endDate ? this.endDate.getMonth() : Infinity, h = this.date.valueOf();
        this.picker.find(".datepicker-days th:eq(1)").text(l[this.language].months[c] + " " + b);
        this.updateNavArrows();
        this.fillMonths();
        var d = new Date(b, c - 1, 28, 0, 0, 0, 0), n = g.getDaysInMonth(d.getFullYear(), d.getMonth());
        d.setDate(n);
        d.setDate(n - (d.getDay() - this.weekStart + 7) % 7);
        n = new Date(d);
        n.setDate(n.getDate() + 42);
        n = n.valueOf();
        html = [];
        for (var k; d.valueOf() < n;) {
            d.getDay() == this.weekStart && html.push("<tr>");
            k = "";
            if (d.getFullYear() < b || d.getFullYear() == b && d.getMonth() < c)k += " old"; else if (d.getFullYear() > b || d.getFullYear() == b && d.getMonth() > c)k += " new";
            d.valueOf() == h && (k += " active");
            if (d.valueOf() < this.startDate || d.valueOf() > this.endDate)k += " disabled";
            html.push('<td class="day' + k + '">' + d.getDate() + "</td>");
            d.getDay() == this.weekEnd && html.push("</tr>");
            d.setDate(d.getDate() + 1)
        }
        this.picker.find(".datepicker-days tbody").empty().append(html.join(""));
        c = this.date.getFullYear();
        h = this.picker.find(".datepicker-months").find("th:eq(1)").text(b).end().find("span").removeClass("active");
        c == b && h.eq(this.date.getMonth()).addClass("active");
        (b < a || b > e) && h.addClass("disabled");
        b == a && h.slice(0, f).addClass("disabled");
        b == e && h.slice(i + 1).addClass("disabled");
        html = "";
        b = 10 * parseInt(b / 10, 10);
        f = this.picker.find(".datepicker-years").find("th:eq(1)").text(b + "-" + (b + 9)).end().find("td");
        b -= 1;
        for (i = -1; 11 > i; i++)html += '<span class="year' + (-1 == i || 10 == i ? " old" : "") + (c == b ? " active" : "") + (b < a || b > e ? " disabled" : "") + '">' + b + "</span>", b += 1;
        f.html(html)
    }, updateNavArrows: function () {
        var a = new Date(this.viewDate), b = a.getFullYear(), a = a.getMonth();
        switch (this.viewMode) {
            case 0:
                -Infinity !== this.startDate && b <= this.startDate.getFullYear() && a <= this.startDate.getMonth() ? this.picker.find(".prev").css({visibility: "hidden"}) : this.picker.find(".prev").css({visibility: "visible"});
                Infinity !== this.endDate && b >= this.endDate.getFullYear() && a >= this.endDate.getMonth() ? this.picker.find(".next").css({visibility: "hidden"}) : this.picker.find(".next").css({visibility: "visible"});
                break;
            case 1:
            case 2:
                -Infinity !== this.startDate && b <= this.startDate.getFullYear() ? this.picker.find(".prev").css({visibility: "hidden"}) : this.picker.find(".prev").css({visibility: "visible"}), Infinity !== this.endDate && b >= this.endDate.getFullYear() ? this.picker.find(".next").css({visibility: "hidden"}) : this.picker.find(".next").css({visibility: "visible"})
        }
    }, click: function (a) {
        a.stopPropagation();
        a.preventDefault();
        a = e(a.target).closest("span, td, th");
        if (1 == a.length)switch (a[0].nodeName.toLowerCase()) {
            case "th":
                switch (a[0].className) {
                    case "switch":
                        this.showMode(1);
                        break;
                    case "prev":
                    case "next":
                        var b = g.modes[this.viewMode].navStep * ("prev" == a[0].className ? -1 : 1);
                        switch (this.viewMode) {
                            case 0:
                                this.viewDate = this.moveMonth(this.viewDate, b);
                                break;
                            case 1:
                            case 2:
                                this.viewDate = this.moveYear(this.viewDate, b)
                        }
                        this.fill()
                }
                break;
            case "span":
                if (!a.is(".disabled")) {
                    if (a.is(".month")) {
                        var c = a.parent().find("span").index(a);
                        this.viewDate.setMonth(c)
                    } else {
                        var f = parseInt(a.text(), 10) || 0;
                        this.viewDate.setFullYear(f)
                    }
                    this.showMode(-1);
                    this.fill()
                }
                break;
            case "td":
                if (a.is(".day") && !a.is(".disabled")) {
                    var j = parseInt(a.text(), 10) || 1, f = this.viewDate.getFullYear(), c = this.viewDate.getMonth();
                    a.is(".old") ? 0 == c ? (c = 11, f -= 1) : c -= 1 : a.is(".new") && (11 == c ? (c = 0, f += 1) : c += 1);
                    this.date = new Date(f, c, j, 0, 0, 0, 0);
                    this.viewDate = new Date(f, c, j, 0, 0, 0, 0);
                    this.fill();
                    this.setValue();
                    this.element.trigger({type: "changeDate", date: this.date});
                    this.isInput ? b = this.element : this.component && (b = this.element.find("input"));
                    b && (b.change(), this.autoclose && b.blur())
                }
        }
    }, mousedown: function (a) {
        a.stopPropagation();
        a.preventDefault()
    }, moveMonth: function (a, b) {
        if (!b)return a;
        var c = new Date(a.valueOf()), e = c.getDate(), j = c.getMonth(), i = Math.abs(b), h, b = 0 < b ? 1 : -1;
        if (1 == i) {
            if (i = -1 == b ? function () {
                return c.getMonth() == j
            } : function () {
                return c.getMonth() != h
            }, h = j + b, c.setMonth(h), 0 > h || 11 < h)h = (h + 12) % 12
        } else {
            for (var d = 0; d < i; d++)c = this.moveMonth(c, b);
            h = c.getMonth();
            c.setDate(e);
            i = function () {
                return h != c.getMonth()
            }
        }
        for (; i();)c.setDate(--e), c.setMonth(h);
        return c
    }, moveYear: function (a, b) {
        return this.moveMonth(a, 12 * b)
    }, keydown: function (a) {
        if (this.picker.is(":not(:visible)"))27 == a.keyCode && this.show(); else {
            var b = !1;
            switch (a.keyCode) {
                case 27:
                    this.hide();
                    a.preventDefault();
                    break;
                case 37:
                case 39:
                    b = 37 == a.keyCode ? -1 : 1;
                    a.ctrlKey ? (this.date = this.moveYear(this.date, b), this.viewDate = this.moveYear(this.viewDate, b)) : a.shiftKey ? (this.date = this.moveMonth(this.date, b), this.viewDate = this.moveMonth(this.viewDate, b)) : (this.date.setDate(this.date.getDate() + b), this.viewDate.setDate(this.viewDate.getDate() + b));
                    this.setValue();
                    this.update();
                    a.preventDefault();
                    b = !0;
                    break;
                case 38:
                case 40:
                    b = 38 == a.keyCode ? -1 : 1;
                    a.ctrlKey ? (this.date = this.moveYear(this.date, b), this.viewDate = this.moveYear(this.viewDate, b)) : a.shiftKey ? (this.date = this.moveMonth(this.date, b), this.viewDate = this.moveMonth(this.viewDate, b)) : (this.date.setDate(this.date.getDate() + 7 * b), this.viewDate.setDate(this.viewDate.getDate() + 7 * b));
                    this.setValue();
                    this.update();
                    a.preventDefault();
                    b = !0;
                    break;
                case 13:
                    this.hide(), a.preventDefault()
            }
            if (b) {
                this.element.trigger({type: "changeDate", date: this.date});
                var c;
                this.isInput ? c = this.element : this.component && (c = this.element.find("input"));
                c && c.change()
            }
        }
    }, showMode: function (a) {
        a && (this.viewMode = Math.max(0, Math.min(2, this.viewMode + a)));
        this.picker.find(">div").hide().filter(".datepicker-" + g.modes[this.viewMode].clsName).show();
        this.updateNavArrows()
    }};
    e.fn.datepicker = function (a) {
        var b = Array.apply(null, arguments);
        b.shift();
        return this.each(function () {
            var c = e(this), f = c.data("datepicker"), j = "object" == typeof a && a;
            f || c.data("datepicker", f = new m(this, e.extend({}, e.fn.datepicker.defaults, j)));
            "string" == typeof a && f[a].apply(f, b)
        })
    };
    e.fn.datepicker.defaults = {};
    e.fn.datepicker.Constructor = m;
    var l = e.fn.datepicker.dates = {en: {days: "Sunday Monday Tuesday Wednesday Thursday Friday Saturday Sunday".split(" "), daysShort: "Sun Mon Tue Wed Thu Fri Sat Sun".split(" "), daysMin: "Su Mo Tu We Th Fr Sa Su".split(" "), months: "January February March April May June July August September October November December".split(" "), monthsShort: "Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec".split(" ")}}, g = {modes: [
        {clsName: "days", navFnc: "Month", navStep: 1},
        {clsName: "months", navFnc: "FullYear", navStep: 1},
        {clsName: "years", navFnc: "FullYear", navStep: 10}
    ], isLeapYear: function (a) {
        return 0 === a % 4 && 0 !== a % 100 || 0 === a % 400
    }, getDaysInMonth: function (a, b) {
        return[31, g.isLeapYear(a) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][b]
    }, validParts: /dd?|mm?|MM?|yy(?:yy)?/g, nonpunctuation: /[^ -\/:-@\[-`{-~\t\n\r]+/g, parseFormat: function (a) {
        var b = a.replace(this.validParts, "\x00").split("\x00"), a = a.match(this.validParts);
        if (!b || !b.length || !a || 0 == a.length)throw Error("Invalid date format.");
        return{separators: b, parts: a}
    }, parseDate: function (a, b, c) {
        if (a instanceof Date)return a;
        if (/^[-+]\d+[dmwy]([\s,]+[-+]\d+[dmwy])*$/.test(a)) {
            for (var f = /([-+]\d+)([dmwy])/, j = a.match(/([-+]\d+)([dmwy])/g), i, h, a = new Date, d = 0; d < j.length; d++)switch (i = f.exec(j[d]), h = parseInt(i[1]), i[2]) {
                case "d":
                    a.setDate(a.getDate() + h);
                    break;
                case "m":
                    a = m.prototype.moveMonth.call(m.prototype, a, h);
                    break;
                case "w":
                    a.setDate(a.getDate() + 7 * h);
                    break;
                case "y":
                    a = m.prototype.moveYear.call(m.prototype, a, h)
            }
            return new Date(a.getFullYear(), a.getMonth(), a.getDate(), 0, 0, 0)
        }
        j = a ? a.match(this.nonpunctuation) : [];
        a = new Date;
        f = {};
        h = "yyyy yy M MM m mm d dd".split(" ");
        var g = {yyyy: function (a, b) {
            return a.setFullYear(b)
        }, yy: function (a, b) {
            return a.setFullYear(2E3 + b)
        }, m: function (a, b) {
            return a.setMonth(b - 1)
        }, d: function (a, b) {
            return a.setDate(b)
        }}, k;
        g.M = g.MM = g.mm = g.m;
        g.dd = g.d;
        a = new Date(a.getFullYear(), a.getMonth(), a.getDate(), 0, 0, 0);
        if (j.length == b.parts.length) {
            for (var d = 0, o = b.parts.length; d < o; d++) {
                k = parseInt(j[d], 10) || 1;
                i = b.parts[d];
                switch (i) {
                    case "MM":
                        k = e(l[c].months).filter(function () {
                            var a = this.slice(0, j[d].length), b = j[d].slice(0, a.length);
                            return a == b
                        });
                        k = e.inArray(k[0], l[c].months) + 1;
                        break;
                    case "M":
                        k = e(l[c].monthsShort).filter(function () {
                            var a = this.slice(0, j[d].length), b = j[d].slice(0, a.length);
                            return a == b
                        }), k = e.inArray(k[0], l[c].monthsShort) + 1
                }
                f[i] = k
            }
            for (d = 0; d < h.length; d++)if (i = h[d], i in f)g[i](a, f[i])
        }
        return a
    }, formatDate: function (a, b, c) {
        c = {d: a.getDate(), m: a.getMonth() + 1, M: l[c].monthsShort[a.getMonth()], MM: l[c].months[a.getMonth()], yy: a.getFullYear().toString().substring(2), yyyy: a.getFullYear()};
        c.dd = (10 > c.d ? "0" : "") + c.d;
        c.mm = (10 > c.m ? "0" : "") + c.m;
        for (var a = [], f = e.extend([], b.separators), g = 0, i = b.parts.length; g < i; g++)f.length && a.push(f.shift()), a.push(c[b.parts[g]]);
        return a.join("")
    }, headTemplate: '<thead><tr><th class="prev"><i class="icon-arrow-left"/></th><th colspan="5" class="switch"></th><th class="next"><i class="icon-arrow-right"/></th></tr></thead>', contTemplate: '<tbody><tr><td colspan="7"></td></tr></tbody>'};
    g.template = '<div class="datepicker dropdown-menu"><div class="datepicker-days f09em"><table class=" table-condensed">' + g.headTemplate + '<tbody></tbody></table></div><div class="datepicker-months"><table class="table-condensed">' + g.headTemplate + g.contTemplate + '</table></div><div class="datepicker-years"><table class="table-condensed">' + g.headTemplate + g.contTemplate + "</table></div></div>"
}(window.jQuery);