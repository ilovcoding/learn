type LogType = Array<any> | string | boolean | number | Object
interface Log {
  show(params: LogType, info?: string): void;
}

function bindLi(value: string, info?: string): void {
  let ol: HTMLElement = document.getElementById('logInfo') as HTMLElement
  let li = document.createElement("li")
  li.innerHTML = info ? `${info}===>${value}` : `${value}`
  ol.appendChild(li)
}

class HTMLLog implements Log {
  show(params: LogType, info?: string) {
    if (typeof params === 'number') {
      bindLi(`${params}`, info)
    } else if (typeof params === 'string') {
      bindLi(params, info)
    }
  }
}

export default HTMLLog
